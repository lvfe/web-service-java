<?php
//
// SimpleXML solution for laboratory work 3 in the course Web Services 7,5hp
// 
// Written by Mikael Hasselmalm / Mid Sweden University
// Date: 2008-10-02
//
  if(!empty($_POST["go"])){

    $indata = $_POST["satval"];

//
// Open XML document for parsing
    $dom = new DOMDocument();
    $dom->load('satellites.xml');
		if (!$dom) {
      echo 'Error while parsing the document';
      exit;
    }
		
		$s = simplexml_import_dom($dom);
		if(!$s) {
      echo 'Error while importing dom for simplexml';
      exit;
    }

//
// Loop through all elements		
		foreach ($s->children() as $k){
		
//
// Look for choosen element
// --sat
			if(!strcmp($indata, $k->attributes()->name)){ 
			  echo $k->attributes()->name . "<br/>";
	
//
// If target found get all data from all transponder elements
// --sat--
//       !-transponder
			  foreach ($k->children() as $j){
		      foreach ($j->attributes() as $a => $b){
            echo $a . "=" . $b . "<br/>";
		      }
			  }
	    }
    }
//
// Close up
  }
?>


