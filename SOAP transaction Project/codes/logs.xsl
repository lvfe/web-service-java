<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<html>
	<body>
		<h2>data "Logs"</h2>
		<table border="1" bgcolor="yellow">
			<tr bgcolor="green">
				<th>Transaction customer_id</th>
				<th>Item price</th>
				<th>the number of Item bought</th>
				<th>the price of Item bought</th>
			</tr>
		<xsl:for-each select="/Equipment_shop/Transaction">
			<tr>
				<td><xsl:value-of select="@Customer_id"/></td>
				<td><xsl:value-of select="showItemPrice"/></td>
				
				<xsl:for-each select="./buyNo">
						
							<td><xsl:value-of select="@NO"/></td>
							<td><xsl:value-of select="Price"/></td>
						
				</xsl:for-each>
				
			</tr>
		</xsl:for-each>
		</table>
	</body>
	</html>
</xsl:template>
</xsl:stylesheet>