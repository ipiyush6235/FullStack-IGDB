document.getElementById('signupbtn').addEventListener('click',(e) => {
    e.preventDefault()
    user_name=document.getElementById('name').value
    user_email = document.getElementById('email').value
    user_dob=document.getElementById('dob').value
    user_password = document.getElementById('pwd').value
    // user_password = document.getElementById('pwd2').value
    console.log(user_name);
    console.log(user_email);
    console.log(user_dob);
    console.log(user_password);
    // =================
    window.localStorage.setItem("my-email",user_email)

    user = {
        name: user_name,
        email: user_email,
        dob: user_dob,
        password: user_password
    }


    const xhr = new XMLHttpRequest()
    url=`http://localhost:8081/users`
    xhr.open('POST' , url )
    xhr.setRequestHeader('Access-Control-Allow-Origin','*')
    xhr.setRequestHeader('Content-Type','application/Json')

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200 ){
            console.log(user);

        }
    }

    xhr.send(JSON.stringify(user))

    window.location.href="./index.html"

})