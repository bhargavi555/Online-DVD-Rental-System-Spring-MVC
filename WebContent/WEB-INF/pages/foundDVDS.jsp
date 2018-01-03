<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="pluginCssAndJs/Cover3D.css">
<script src="pluginCssAndJs/Cover3D.js"></script>


</head>
<body>
<c:forEach var="dvd" items="${foundDVDS}">
	<div>
		<div class="jquery-script-center">

			<div class="jquery-script-ads">
				<script type="text/javascript">
				<!--
					google_ad_client = "ca-pub-2783044520727903";
					/* jQuery_demo */
					google_ad_slot = "2780937993";
					google_ad_width = 728;
					google_ad_height = 90;
				//-->
				</script>
				<script type="text/javascript"
					src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
					
				</script>
			</div>
			<div class="jquery-script-clear"></div>
		</div>
	</div>
	
	<div class="container">

		<div class="col-md-2">
			<div id="cover1">
				
				<img src="${dvd.getImagePath()}" />
			
			</div>
		</div>
	
		
	

		<script>
			$('#cover1').CoverTresD({
				color : '#f00'
			});
			$('#cover2').CoverTresD();
			$('#cover3').CoverTresD();
			$('#cover4').CoverTresD();
			$('#cover5').CoverTresD();
		</script>
	</div>
		</c:forEach>
	
</body>
</html>