document.addEventListener("DOMContentLoaded", function() {
    const inputField = document.getElementById('user-input');
    inputField.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            sendMessage();
        }
    });
});
function sendMessage() {
    const userInput = document.getElementById('user-input').value;
    if (userInput.trim() === "") return;

    addMessage(userInput, 'user');
    document.getElementById('user-input').value = '';

    const botResponse = getBotResponse(userInput);
    setTimeout(() => addMessage(botResponse, 'bot'), 500);
}

function addMessage(message, type) {
    const messageElement = document.createElement('div');
    messageElement.className = `message ${type}`;
    messageElement.textContent = message;

    const chatBox = document.getElementById('chat-box');
    chatBox.appendChild(messageElement);
    chatBox.scrollTop = chatBox.scrollHeight;
}

function getBotResponse(userInput) {
    const responses = {
        "greetings": ["Hi there! How can I assist you?", "Hello! How can I help you today?", "Hey! What can I do for you?"],
        "how are you": ["I'm just a bot, but I'm here to help you!", "I'm doing great, thanks for asking! How can I assist you today?"],
        "bye": ["Goodbye! Have a great day!", "See you later! Take care!", "Bye! Hope to see you soon!"],
        "thank you": ["You're welcome!", "Happy to help!", "Anytime!"],
        "menu": ["We offer a variety of coffee including Espresso, Latte, Cappuccino, and Americano. Would you like to know more?", "Our menu includes Espresso, Latte, Cappuccino, and Americano. Interested in something specific?"],
        "price": ["Our coffee prices range from Rs.150 to Rs.300 depending on the type and size. Would you like to place an order?", "Prices vary between Rs.150 and Rs.300. Can I help you with an order?"],
        "order": ["Sure! Please let me know if anything else you'd like to order.", "I'd be happy to take your order. What would you like?","yeah,Sure","Okay,Anything else?","Yeah sure!","Sure"],
        "hours": ["We are open from 7 AM to 7 PM every day.", "Our hours are 7 AM to 7 PM daily."],
        "location": ["We are located at Baner,Pune.", "You can find us at Baner,Pune."]
    };

    const userMessage = userInput.toLowerCase().trim();
    
    if (userMessage.includes("hello") || userMessage.includes("hi") || userMessage.includes("hey")) {
        return getRandomResponse(responses["greetings"]);
    } else if (userMessage.includes("how are you")) {
        return getRandomResponse(responses["how are you"]);
    } else if (userMessage.includes("bye") || userMessage.includes("goodbye")) {
        return getRandomResponse(responses["bye"]);
    } else if (userMessage.includes("thank you") || userMessage.includes("thanks")) {
        return getRandomResponse(responses["thank you"]);
    } else if (userMessage.includes("menu") || userMessage.includes("coffee")) {
        return getRandomResponse(responses["menu"]);
    } else if (userMessage.includes("price") || userMessage.includes("cost")) {
        return getRandomResponse(responses["price"]);
    } else if (userMessage.includes("order") || userMessage.includes("want to have a coffee") ||userMessage.includes("Latte") || userMessage.includes("Espresso") || userMessage.includes("Cappuccino") || userMessage.includes("Americano")) {
        return getRandomResponse(responses["order"]);
    } else if (userMessage.includes("hours") || userMessage.includes("open")) {
        return getRandomResponse(responses["hours"]);
    } else if (userMessage.includes("location") || userMessage.includes("where are you")) {
        return getRandomResponse(responses["location"]);
    } else {
        return "I'm sorry, I didn't understand that. Can you please rephrase?";
    }
}

function getRandomResponse(responseArray) {
    const randomIndex = Math.floor(Math.random() * responseArray.length);
    return responseArray[randomIndex];
}


