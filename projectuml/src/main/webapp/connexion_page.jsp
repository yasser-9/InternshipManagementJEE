<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<section class="vh-100" style="background-color: #508bfc;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">Sign in</h3>
			<form action="Test1" method="post" name="form1">

            <div class="form-outline mb-4">
              <input type="email" name="email" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Email adress" />
              <!--label class="form-label" for="typeEmailX-2"></label-->
            </div>

            <div class="form-outline mb-4">
              <input type="password" name="passs" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Password"/>
              <!--label class="form-label" for="typePasswordX-2"></label-->
            </div>
			<button class="btn btn-primary btn-lg btn-block" type="submit" >Login</button>

			</form>

            <!-- Checkbox -->
     

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</html>