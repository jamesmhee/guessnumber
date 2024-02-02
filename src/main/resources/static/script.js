window.addEventListener("DOMContentLoaded", ()=>{
    const queryString = window.location.search
    const urlParams = new URLSearchParams(queryString)

    const inputNumber = document.querySelector("#inputNumber")
    const form = document.querySelector("#formAction")
    const randomNumber = document.querySelector("#randomNumber")

    inputNumber.addEventListener("keyup", (event)=>{
        if(event.target.value === '' || event.target.value.length !== 3){

        }
    })
    // Event random    
    if(urlParams.has("submit")){
        randomNumber.classList.remove("blur-lg")
    }

    form.addEventListener("submit", (event)=>{
        // event.preventDefault()
        randomNumber.classList.remove("blur-lg")        
    })
})