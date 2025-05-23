const API_URL = "http://localhost:3000/events";
const eventList = document.getElementById("eventList");
const form = document.getElementById("eventForm");
const title = document.getElementById("title");
const venue = document.getElementById("venue");
const date = document.getElementById("date");

// Fetch and display existing events
fetch(API_URL)
  .then((res) => res.json())
  .then((events) => events.forEach(showEvent));

// Render event item
function showEvent(event) {
  const li = document.createElement("li");
  li.className = "list-group-item";
  li.textContent = `${event.title} @ ${event.venue} on ${event.date}`;
  eventList.appendChild(li);
}

// Add new event
form.addEventListener("submit", (e) => {
  e.preventDefault();
  const newEvent = {
    title: title.value,
    venue: venue.value,
    date: date.value,
  };

  fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(newEvent)
  })
    .then((res) => res.json())
    .then((event) => {
      showEvent(event);
      form.reset();
    });
});
