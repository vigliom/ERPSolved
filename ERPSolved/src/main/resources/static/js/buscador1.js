document.addEventListener("keyup", e=>{
    if(e.target.matches("#buscadorT")){
        if(e.key === "Escape")e.target.value = ""

        document.querySelectorAll(".articuloT").forEach(art => {
            art.textContent.toLowerCase().includes(e.target.value.toLowerCase())
                ? art.classList.remove("filtro")
                : art.classList.add("filtro")
        })
    }
})