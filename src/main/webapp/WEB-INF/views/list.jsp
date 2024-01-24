<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script>
    function goList(){ // javascript, jQuery
        // 서버와 직접 통신
        $.ajax({
              url : "/shopping/ajaxList.do", // pojo
              type : "get",
              dataType : "json",
              success : bookList,
              error : function(){  alert("error");  }
           });
    }
    function bookList(data){
         //alert(data); // JSON Array
         console.log(data);
         // 동적인 뷰를 만들어준다~~~
         var result="<table class='table table-bordered table-hover'>";
             result+="<thead>";
                 result+="<tr>";
                     result+="<th>번호</th>";
                     result+="<th>제목</th>";
                     result+="<th>가격</th>";
                     result+="<th>저자</th>";
                     result+="<th>페이지</th>";
                 result+="</tr>";
             result+="</thead>";
             result+="<tbody>";
             // data->[ {    }, {    } , {   }....]
             $.each(data, function(index,object){
                  result+="<tr>";
                      result+="<td>"+object.num+"</td>";
                      result+="<td>"+object.title+"</td>";
                      result+="<td>"+object.price+"</td>";
                      result+="<td>"+object.name+"</td>";
                      result+="<td>"+object.page+"</td>";
                  result+=" </tr>";
            });
             result+="</tbody>";
         result+="</table>";
         $("#list").html(result);

         if($("#list").css("display")=="none"){
            $("#list").css("display","block");
         }else{
             $("#list").css("display","none");
         }
    }
    function goDel(num){
          // 삭제요청, URL돌려서요청, ajax요청
         location.href="/shopping/delete.do?num="+num; // GET방식 요청
    }
</script>
</head>
<body>

    <div class="container">
        <h2>MVC Framework</h2>
        <div class="card">
            <div class="card-header">
             <c:if test="${empty uservo}">
                <form class="form-inline" action="/shopping/login.do" method="post">
                  <label for="text">아이디:</label>
                  <input type="text" class="form-control" placeholder="Enter 아이디" id="username" name="username">
                  <label for="pwd">패스워드:</label>
                  <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
                  <button type="submit" class="btn btn-primary">로그인</button>
                </form>
            </c:if>
            <c:if test="${!empty uservo}">
              <div class="row">
                  <div class="col-8 text-right">
                    Welcome, ${uservo.name} 님 환영 합니다.
                  </div>
                  <div class="col-4 text-left">
                    <form class="form-inline" action="/shopping/logout.do" method="post">
                                   <button type="submit" class="btn btn-primary btn-sm">로그아웃</button>
                     </form>
                  </div>
              </div>
            </c:if>
            </div>
            <div class="card-body">
                <table class="table table-bordered table-hover">
                     <thead>
                       <tr>
                          <th>번호</th>
                          <th>제목</th>
                          <th>가격</th>
                          <th>저자</th>
                          <th>페이지</th>
                          <th>삭제</th>
                       </tr>
                     </thead>
                     <tbody>
                      <c:forEach var="book" items="${list}">
                              <tr>
                                <td>${book.num}</td>
                                <td>${book.title}</td>
                                <td>${book.price}</td>
                                 <td>${book.name}</td>
                                 <td>${book.page}</td>
                                 <c:if test="${!empty uservo}">
                                  <td><button type="button" class="btn btn-sm btn-danger" onclick="goDel(${book.num})">삭제</button></td>
                                 </c:if>
                             </tr>
                       </c:forEach>
                     </tbody>
                </table>
                <button class="btn btn-secondary btn-sm" onclick="location.href='/shopping/register.do'">책 등록</button>
                <button class="btn btn-secondary btn-sm" onclick="goList()">BookList</button>
            </div>
            <div id="list" class="container" style="display:none">
                여기에 책 리스트 출력
            </div>
            <div class="card-footer">패스트캠퍼스_BE7_박매일</div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

