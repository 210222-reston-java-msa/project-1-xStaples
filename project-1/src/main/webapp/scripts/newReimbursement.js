const sendForm = () => {

    let curUser = sessionStorage.getItem('currentUser');

    let amount = document.getElementById('formAmount');
    let type = document.getElementById('formType');
    let receipt = document.getElementById('formReceipt');
    let description = document.getElementById('formDescription');

    

    // let formTemplete = {
    //     amount: amount,
    //     created: 
    // }

    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('currentForm', this.responseText);
            window.location = "http://localhost:8080/project-1/home.html";

        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed submit form");

            let resultDiv = document.getElementById('formResult');
            resultDiv.innerHTML = "Failed to submit!  Something went wrong"
        }
    }


    xhr.open("POST", "http://localhost:8080/project-1/submitform")


    xhr.send(JSON.stringify(loginTemplate)) // this is converting out js object to JSON
}

const logout = () => {
		
	let xhr = new XMLHttpRequest();
	
	xhr.open("POST", "http://localhost:8080/project-1/logout");
	xhr.send();
	
	sessionStorage.removeItem('currentUser');
	window.location = "http://localhost:8080/project-1/";
	
}