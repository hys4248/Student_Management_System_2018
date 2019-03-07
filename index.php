ServerRoot "${HOME}/httpd"<?php
require_once 'PhpReverseProxy.class.php';
$proxy=new PhpReverseProxy();
$proxy->port="80";
$proxy->host="yompc.ml";
//$proxy->ip="1.1.1.1";
$proxy->forward_path="";
$proxy->connect();
$proxy->output();
?>
