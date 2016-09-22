<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<html>
	<body>
		<h2>current price</h2>
		<table border="1" bgcolor="yellow">
			<tr bgcolor="green">
				<th>item</th>
				<th>Item No</th>
				<th>Item Price</th>
			</tr>
		<xsl:for-each select="/Equipment_shop/Transaction">
			<tr>
				<td></td>
				<td>
					<xsl:for-each select="./Item">
						<tr>
							<td><xsl:value-of select="@NO"/></td>	
						</tr>
					</xsl:for-each>
				</td>
				<td>
				<xsl:for-each select="./Item">
						<tr>
							<td><xsl:value-of select="Price"/></td>
						</tr>
					</xsl:for-each>
				</td>
			</tr>
		</xsl:for-each>
		</table>
	</body>
	</html>
</xsl:template>
</xsl:stylesheet>