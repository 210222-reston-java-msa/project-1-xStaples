const userLogin = () => {

    let userName = document.getElementById('UNInput').value;
    let password = document.getElementById('PWInput').value;

    let loginTemplate = {
        username: userName,
        password: password
    }


    // begin some AJAX workflow....

    // 1. get the XMLHttpRequest Object i.e ... let xhr = ....
    let xhr = new XMLHttpRequest();

    // 2. xhr.onreadystatechange
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log("success");

            sessionStorage.setItem('currentUser', this.responseText);


            window.location = "http://localhost:8080/project-1/home.html";
        }

        if (this.readyState === 4 && this.status === 204) { // 204 means NO CONTENT FOUND (but connection was made)

            console.log("failed to find user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login!  Username or Password is incorrect"
        }
    }


    xhr.open("POST", "http://localhost:8080/project-1/login")


    xhr.send(JSON.stringify(loginTemplate)) // this is converting out js object to JSON
}