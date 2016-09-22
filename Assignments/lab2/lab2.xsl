<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<html>
	<body>
		<table border="1" bgcolor="yellow">
			<tr>
				<th>Satellite</th>
				<th>Frequency</th>
			</tr>
			<xsl:for-each select="/satellites/sat">
			<xsl:variable name="Aname" select="./@name"/>
			<tr>
				<td><xsl:value-of select="@name"/></td>
				<td></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
				<xsl:for-each select="./transponder">
				<xsl:sort select="@frequency" data-type="number" order="descending"/>
					<tr>
					<td>
						<xsl:value-of select="./@frequency"/>
					</td>
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