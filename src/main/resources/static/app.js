const API = "/api/tasks";

const form = document.getElementById("taskForm");
const errorEl = document.getElementById("error");
const tasksEl = document.getElementById("tasks");

form.addEventListener("submit", async e => {
    e.preventDefault();
    errorEl.textContent = "";

    const res = await fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            title: title.value,
            description: description.value,
            priority: priority.value
        })
    });

    if (!res.ok) {
        const data = await res.json();
        errorEl.textContent = Object.values(data)[0];
        return;
    }

    form.reset();
    loadTasks();
});

async function loadTasks() {
    const res = await fetch(API);
    const data = await res.json();

    tasksEl.innerHTML = "";
    data.content.forEach(t => {
        tasksEl.innerHTML += `
            <div class="task">
                <h3>${t.title}</h3>
                <p>${t.description}</p>
                <small>Priority: ${t.priority}</small>
                <button onclick="deleteTask(${t.id})">Delete</button>
            </div>
        `;
    });
}

async function deleteTask(id) {
    await fetch(`${API}/${id}`, { method: "DELETE" });
    loadTasks();
}

loadTasks();
