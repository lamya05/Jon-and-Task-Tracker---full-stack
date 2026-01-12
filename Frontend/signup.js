// ==========================================
// 1. SIGNUP LOGIC (Pudhu User Create Panna)
// ==========================================
const signupForm = document.getElementById('signupForm');
if (signupForm) {
    signupForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        
        const userObj = {
            username: document.getElementById('username').value,
            email: document.getElementById('email').value,
            password: document.getElementById('password').value
        };

        try {
            const response = await fetch("http://localhost:8081/api/users/signup", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(userObj)
            });

            if (response.ok) {
                alert("Signup Success! Ippo Login pannunga.");
                window.location.href = "login.html";
            } else {
                alert("Email already exists! Vera email try pannunga.");
            }
        } catch (err) {
            console.error("Signup Error:", err);
        }
    });
}

// ==========================================
// 2. LOGIN LOGIC (Existing User Login Panna)
// ==========================================
const loginForm = document.getElementById('loginForm');
if (loginForm) {
    loginForm.addEventListener('submit', async (e) => {
        e.preventDefault();

        const loginData = {
            email: document.getElementById('loginEmail').value,
            password: document.getElementById('loginPassword').value
        };

        try {
            const response = await fetch("http://localhost:8081/api/users/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(loginData)
            });

            const result = await response.text();
            console.log("Original Response:", result);

            if (result.trim() === "Login Success") {
                // Browser memory-la user email-ah store panrom
                localStorage.setItem("loggedInUser", loginData.email);
                
                alert("Login Success! Welcome.");
                window.location.href = "dashboard.html";
            } else {
                alert("Backend sonna message: " + result); 
            }
        } catch (err) {
            console.error("Login Error:", err);
            alert("Backend server connection failed!");
        }
    });
}