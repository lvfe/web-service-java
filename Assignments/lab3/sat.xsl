<?xml version='1.0' encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


  <xsl:template match="/">
    
    <html>        
      <body>
        <form method="POST" action="visa.php">
          
          <select name="satval">
            <xsl:for-each select="satellites/sat">
  			
              <option>
                <xsl:value-of select="@name"/>
              </option>
            
            
            </xsl:for-each>
           
          </select>
          <input type="submit" name="go" value="Visa innehåll" />
      
        </form>
      </body>
    </html>
   
    
  </xsl:template>
</xsl:stylesheet> 