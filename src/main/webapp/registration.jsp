<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PG Rental Registration Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <!-- SweetAlert2 CSS -->
    <link rel="stylesheet" href="https://unpkg.com/sweetalert/dist/sweetalert.css">
</head>

<body>
    <input type="hidden" name="status" id="status" value="<%= request.getAttribute("status") %>">

    <div class="row vh-100 g-0">
        <!-- Left Side -->
        <div class="col-lg-6 position-relative d-none d-lg-block">
            <img src="images/bg.jpg" class="bg-holder" alt="">
        </div>
        <!-- / Left Side -->
        <!-- Right Side -->
        <div class="col-lg-6 nunito-sans-body">
            <div class="row align-items-center justify-content-center h-100 g-0">
                <div class="col col-sm-6 col-lg-7 col-xl-6">
                    <!-- Logo -->
                    <a href="#" class="d-flex justify-content-center mb-4">
                        <img src="images/logo.jpg" alt="" width="60">
                    </a>
                    <!-- / Logo -->
                    <div class="text-center mb-4">
                        <h3 class="fw-bold">Sign Up</h3>
                        <p class="text-secondary">Create your account</p>
                    </div>

                    <!-- Registration Form -->
                    <form method="post" action="register" onsubmit="return validateForm()">
                        <div class="input-group justify-content-center mb-3">
                            <span class="input-group-text">
                                <i class='bx bx-user'></i>
                            </span>
                            <input type="text" name="name" class="form-control fs-6" placeholder="Full Name">
                        </div>
                        <div class="input-group justify-content-center mb-3">
                            <span class="input-group-text">
                                <i class='bx bx-mail-send'></i>
                            </span>
                            <input type="email" name="email" class="form-control fs-6" placeholder="Email">
                        </div>
                        <div class="input-group justify-content-center mb-3">
                            <span class="input-group-text">
                                <i class='bx bx-lock-alt'></i>
                            </span>
                            <input type="password" name="pass" id="pass" class="form-control fs-6" placeholder="Password">
                        </div>
                        <div class="input-group justify-content-center mb-3">
                            <span class="input-group-text">
                                <i class='bx bx-lock-alt'></i>
                            </span>
                            <input type="password" name="re_pass" id="re_pass" class="form-control fs-6" placeholder="Confirm Password">
                        </div>
                        <div class="input-group justify-content-center mb-3">
                            <span class="input-group-text">
                                <i class='bx bxs-phone'></i>
                            </span>
                            <input type="text" name="mobile" class="form-control fs-6" placeholder="Mobile Number">
                        </div>
                        <button class="btn btn-outline-custom-login w-100 mb-3">Sign Up</button>
                    </form>
                    <!-- / Registration Form -->
                    <div class="text-center">
                        <small>Already have an account?
                            <a href="login.jsp" class="fw-bold">Log in</a>
                        </small>
                    </div>
                </div>
            </div>
        </div>
        <!-- / Right Side -->
    </div>

    <!-- Script to show success popup -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript">

        const status = document.getElementById("status").value;

        // If status is success, show success popup
        if (status === 'success') {
            swal("Congrats", "Account Created Successfully", "success");
        }
        if (status === 'failed') {
            swal("Failed","Account Not Created","error");
        }

        function validateForm() {
            var pass = document.getElementById("pass").value;
            var rePass = document.getElementById("re_pass").value;

            if (pass !== rePass) {
                swal("Error", "Passwords do not match", "error");
                return false;
            }
            return true;
        }
    </script>

</body>

</html>
