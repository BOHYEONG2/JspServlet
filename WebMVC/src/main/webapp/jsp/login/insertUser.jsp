<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <style>
.container {
  width: 40%;
  margin: 0 auto;
  padding: 20px;
  background-color: #f7f7f7;
  border: 1px solid #ddd;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 8px;
  font-size: 14px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

input[type="submit"] {
  padding: 8px 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #45a049;
}

</style>
    <script>
        // 아이디 유효성 검사 함수
        function validateId() {
            var id = $("#id").val();
            var idRegex = /^[a-zA-Z0-9]{1,16}$/;
            if (!idRegex.test(id)) {
                $("#id").css("border-color", "red");
                return false;
            } else {
                $("#id").css("border-color", ""); // 기존의 색으로 복원
                return true;
            }
        }

        // 비밀번호 유효성 검사 함수
        function validatePassword() {
            var password = $("#password").val();
            var passwordRegex = /^[a-zA-Z0-9]{1,16}$/;
            if (!passwordRegex.test(password)) {
                $("#password").css("border-color", "red");
                return false;
            } else {
                $("#password").css("border-color", ""); // 기존의 색으로 복원
                return true;
            }
        }

        function validatePhone() {
        	  var phone = $("#phone").val();
        	  var phoneRegex = /^\d{3}-\d{3,4}-\d{4}$/;
        	  if (!phoneRegex.test(phone)) {
        	    $("#phone").css("border-color", "red");
        	    return false;
        	  } else {
        	    $("#phone").css("border-color", ""); // 기존의 색으로 복원
        	    return true;
        	  }
        	}
        	
        function checkSubmit() {
        	  var id = $("#id").val();
        	  if (validateId() && validatePassword() && validateBirthday() && validatePhone()) {
        	    console.log('duplicate check start...')
        	    $.ajax({
        	      url: "/WebMVC/checkduplicateid.do",
        	      method: "POST",
        	      data: { id: id },
        	      success: function(response) {
        	        response = response.trim();
        	        if (response === "duplicate") {
        	          alert("중복된 아이디입니다. 다른 아이디를 사용해주세요.");
        	        } else if (response === "success") {
        	          $("#signupForm")[0].submit();
        	        }
        	      }
        	    });
        	  }

        	  return false;
        	}

        	$(document).ready(function() {
        	  $("#id").on("input", function() {
        	    validateId();
        	  });

        	  $("#password").on("input", function() {
        	    validatePassword();
        	  });

  <%--      	  $("#birthday").on("input", function() {
        	    validateBirthday();
        	  });
        	  --%>
        	  $("#phone").on("input", function() {
        	    validatePhone();
        	  });
        	});
    </script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
    <div class="container">
        <h2>회원가입</h2>
       <form action="insertUserProcess.do" method="post" name="inputForm" id="signupForm" onsubmit="return checkSubmit()">
        <div class="form-group">
            <label for="id">아이디:</label>
            <input type="text" id="id" name="id" placeholder="영문자와 숫자, 1~16자" required>
        </div>
        <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" placeholder="영문자와 숫자, 1~16자" required>
        </div>
        <div class="form-group">
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="phone">전화번호:</label>
            <input type="text" id="phone" name="phone" placeholder="전화번호 형식: 010-1234-5678" required>
        </div>
        <div class="form-group">
            <label for="birthday">생일:</label>
            <input type="text" id="birthday" name="birthday" placeholder="생일 형식: YYYYMMDD" required>
        </div>
        <div>
            <input type="submit" value="회원가입">
        </div>
    </form>
    </div>
</body>
</html>