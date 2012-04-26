<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="ar.com.fluxit.jqa.result.CheckingResult">
		<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
				<title>
					JQA check results for:
					<xsl:value-of select="project" />
				</title>
			</head>
			<body>
				<div>
					<b>Project name:</b>
					<xsl:value-of select="project" />
				</div>
				<div>
					<b>Check date:</b>
					<xsl:value-of select="date" />
				</div>
				<div>
					<b>Violations:</b>
					<table border="1">
						<tr>
							<th>Class</th>
							<th>Message</th>
							<th>Rule</th>
							<th>Priority</th>
						</tr>
						<xsl:for-each select="ruleChecksFailed/ar.com.fluxit.jqa.result.RuleCheckFailed">
							<tr>
								<td>
									<xsl:value-of select="targetClassName" />
								</td>
								<td>
									<xsl:value-of select="ruleMessage" />
								</td>
								<td>
									<xsl:value-of select="ruleName" />
								</td>
								<td>
									<xsl:value-of select="rulePriority" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>