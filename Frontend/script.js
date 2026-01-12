document.getElementById("signupForm")?.addEventListener("submit", function(e) {
    e.preventDefault();
    alert("Signup UI working ✅\nBackend later connect pannalaam");
});


document.getElementById("loginForm")?.addEventListener("submit", function (e) {
    e.preventDefault();

    const email = document.getElementById("loginEmail").value.trim();
    const password = document.getElementById("loginPassword").value.trim();

    document.getElementById("loginEmailError").innerText = "";
    document.getElementById("loginPasswordError").innerText = "";

    let valid = true;

    if (email === "") {
        document.getElementById("loginEmailError").innerText = "Email is required";
        valid = false;
    }

    if (password === "") {
        document.getElementById("loginPasswordError").innerText = "Password is required";
        valid = false;
    }

    if (valid) {
        alert("Login validation success ✅");
        // later → backend API call
    }
});

document.getElementById("signupForm")?.addEventListener("submit", function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    document.querySelectorAll(".error").forEach(el => el.innerText = "");

    let valid = true;

    if (name === "") {
        document.getElementById("nameError").innerText = "Name is required";
        valid = false;
    }

    if (!email.includes("@")) {
        document.getElementById("emailError").innerText = "Enter valid email";
        valid = false;
    }

    if (password.length < 6) {
        document.getElementById("passwordError").innerText = "Password must be 6 characters";
        valid = false;
    }

    if (valid) {
        alert("Signup validation success ✅");
        // later → backend API call
    }
});

localStorage.setItem('registeredName', name); // Name-ah save panrom
window.location.href = "login.html";
