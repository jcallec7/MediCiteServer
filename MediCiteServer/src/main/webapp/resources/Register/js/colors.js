 var strength = {
									              0: "Bien baja",
									              1: "Baja",
									              2: "OK",
									              3: "Buena",
									              4: "Excelente"
									            }
									             
									            var password = document.getElementById('password');
									            var meter = document.getElementById('password-strength');
									            var text = document.getElementById('password-strength-text');
									 
									            password.addEventListener('input', function() {
									                var val = password.value;
									                var result = zxcvbn(val);
									 
									                // This updates the password strength meter
									                meter.value = result.score;
									 
									                // This updates the password meter text
									                if (val !== "") {
									                    text.innerHTML = "Seguridad: " + strength[result.score]; 
									                } else {
									                    text.innerHTML = "";
									                }
									            });