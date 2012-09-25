<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="ar.com.fluxit.jqa.result.CheckingResult">
		<xsl:variable name="apos">'</xsl:variable>
		<xsl:variable name="bapos">"</xsl:variable>
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
				<title>
					JQA check results for:
					<xsl:value-of select="project" />
				</title>
				<link rel="stylesheet" type="text/css" href="lib/resources/css/ext-all.css" />
				<link rel="stylesheet" type="text/css" href="lib/default.css" />
				<script type="text/javascript" src="lib/ext-all.js" />
				<script language="javascript">
					Ext.define('Violation',{
						extend: 'Ext.data.Model',
						fields: [ 'Priority', 'Rule', 'TargetClass', 'Message']
					});

					var store = Ext.create('Ext.data.Store', {
						model: 'Violation',
						autoLoad: true,
						data: [
						<xsl:for-each select="ruleChecksFailed/ar.com.fluxit.jqa.result.RuleCheckFailed">
							<xsl:variable name="message" select="translate(ruleMessage,$apos,$bapos)"/>
							<xsl:variable name="priority">
								<xsl:choose>
									<xsl:when test="rulePriority=1">Blocker</xsl:when>
									<xsl:when test="rulePriority=2">Critical</xsl:when>
									<xsl:when test="rulePriority=3">Major</xsl:when>
									<xsl:when test="rulePriority=4">Minor</xsl:when>
									<xsl:when test="rulePriority=5">Info</xsl:when>
									<xsl:otherwise>n/d</xsl:otherwise>
								</xsl:choose>
							</xsl:variable>
							{Priority: '<xsl:value-of select="$priority" />', Rule: '<xsl:value-of select="ruleName" />', TargetClass:'<xsl:value-of select="targetClassName" />', Message:'<xsl:value-of select="$message" />'},
						</xsl:for-each>
							   ]
					});
				</script>
				<script type="text/javascript" src="lib/xml-grid.js" />
			</head>
			<body>
				<div>
					<b>Project name: &#160;</b>
					<xsl:value-of select="project" />
				</div>
				<div>
					<b>Check date: &#160;</b>
					<xsl:value-of select="date" />
				</div>
				<div>
					<b>Violations:</b>
					<div id="violations-grid" />
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>