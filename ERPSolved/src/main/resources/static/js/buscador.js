document.addEventListener("keyup", e=>{
    if(e.target.matches("#buscador")){
        if(e.key === "Escape")e.target.value = ""

        document.querySelectorAll(".articulo").forEach(art => {
            art.textContent.toLowerCase().includes(e.target.value.toLowerCase())
                ? art.classList.remove("filtro")
                : art.classList.add("filtro")
        })
    }
})