window.addEventListener("DOMContentLoaded", ()=>{
    const queryString = window.location.search
    const urlParams = new URLSearchParams(queryString)

    const inputNumber = document.querySelector("#inputNumber")
    const form = document.querySelector("#formAction")
    const randomNumber = document.querySelector("#randomNumber")
    const btnsubmit = document.querySelector("#btn-submit")
    
    inputNumber.addEventListener("focusout", (event)=>{        
        if(event.target.value === '' || event.target.value === " " || event.target.value === "  " || event.target.value.length > 3){
            alert("Please field number 1 - 3 digits.")            
            btnsubmit.disabled = true
        }else{
            btnsubmit.disabled = false
        }
    })
    // Event random    
    if(urlParams.has("submit")){
        randomNumber.classList.remove("blur-lg")
    }

    form.addEventListener("submit", (event)=>{
        // event.preventDefault()
        randomNumber.classList.remove("blur-lg")        
        setTimeout(()=>{
            console.log("sd")
        }, 1000)
    })
})