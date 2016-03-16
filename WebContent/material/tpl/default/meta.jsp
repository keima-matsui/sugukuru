<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/Sugukuru/images/favicon.ico" rel="shortcut icon" />

<script type="text/javascript" src="/Sugukuru/material/js/jquery-1.9.1.min.js"></script>

<link rel="stylesheet" href="/Sugukuru/material/css/reset.css" type="text/css" media="all" />
<link rel="stylesheet" href="/Sugukuru/material/tpl/default/css/base.css" type="text/css" />

<link rel="stylesheet" href="/Sugukuru/material/tpl/default/css/jquery.jscrollpane.css" type="text/css"/>
<script type="text/javascript" src="/Sugukuru/material/js/jquery.carouFredSel-6.2.1-packed.js"></script>

<script type="text/javascript">
$(function() {
	var nav = $('.overimg');
	nav.hover(
		function(){
			$(this).fadeTo(500,0.5);
		},
		function () {
			$(this).fadeTo(500,1);
		}
	);
});
</script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-1788254-16', 'ecnote.jp');
  ga('send', 'pageview');

</script>