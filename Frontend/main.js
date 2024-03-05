const cardsContainer = document.querySelector('.cards');
console.log(cardsContainer);
const api = "http://localhost:8080/api/platos";
document.addEventListener('DOMContentLoaded', async () => {
    const data = await (await fetch(api)).json();
    console.log(data);

    const cards = data.map(plato => `
    <div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">${plato.nombre}</h5>
    <h6 class="card-subtitle mb-2 text-body-secondary">${plato.precio}</h6>
    <p class="card-text">${plato.descripcion}</p>
    <button type="submit" class="bttnUpdate">Actualizar Plato</button>
    <button type="submit" class="bttnEliinar">Eliminar Plato</button>
  </div>
</div>
    `).join("");
    cardsContainer.innerHTML = cards;

    const form = document.getElementById("platoForm")
    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const data = Object.fromEntries(new FormData(e.target))
        let config = {
            method: "POST",
            headers: { "content-type": "application/json" },
            body: JSON.stringify(data),
        };
        await fetch(api + '/add', config);
        window.location.reload();
    })
    const updateButtons = document.querySelectorAll(".bttnUpdate");
    updateButtons.forEach(button => {
        button.addEventListener("click", async (e) => {
            const platoId = e.target.getAttribute("data-id");
            const plato = data.find(plato => plato._id === platoId);
            document.getElementById("nombre").value = plato.nombre;
            document.getElementById("descripcion").value = plato.descripcion;
            document.getElementById("precio").value = plato.precio;
            // Aquí puedes abrir el formulario de actualización y prellenarlo con los datos del plato seleccionado
        });
    });
})

