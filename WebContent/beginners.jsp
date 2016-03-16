<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="material/tpl/default/meta.jsp" %>
<script type="text/javascript">
$(function() {


				$('#foo0').carouFredSel({
					auto:4000,
					scroll : {
						items           : 1,
            duration        : 1000,
						easing:"linear"
        }

					});
$('#foo2').carouFredSel({
					pagination: "#pager2",
					items               : 1,
				auto:4000,
					scroll : {
            items           : 1,
						fx			: "crossfade",
            duration        : 2000
        }
				});
				});


</script>
</head>
<body>
<div id="container">
  <header id="header">
    <%@ include file="material/tpl/default/header.jsp" %>
  </header>
  <div class="content">
    <aside id="leftside">
      <%@ include file="material/tpl/default/leftside.jsp" %>
    </aside>

    <article id="center">
    <%@ include file="material/tpl/default/searchForm.jsp" %>
      <%@ include file="page/beginners.jsp" %>
    </article>

    <aside id="rightside">
      <%@ include file="material/tpl/default/rightside.jsp" %>
    </aside>
    <div class="empty"> &nbsp; </div>
  </div>
</div>
<footer id="footer">
  <div class="content">
    <%@ include file="material/tpl/default/footer.jsp" %>
  </div>
</footer>
</body>
</html>