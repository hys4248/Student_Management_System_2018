#!/bin/bash
Green_font="\033[32m" && Yellow_font="\033[33m" && Red_font="\033[31m" && Font_suffix="\033[0m"
Info="${Green_font}[Info]${Font_suffix}"
Error="${Red_font}[Error]${Font_suffix}"
echo -e "
${Green_font}
#================================================
# Project:  tcp_nanqinlang lkl-haproxy
# Platform: --Debian --openvz --nocheckvirt
# Version: 1.1.1
# Author: nanqinlang
# Blog:   https://sometimesnaive.org
# Github: https://github.com/nanqinlang
#================================================
${Font_suffix}"



directory(){
	[[ ! -d /home/tcp_nanqinlang ]] && mkdir -p /home/tcp_nanqinlang
	cd /home/tcp_nanqinlang
}

config(){
	# choose one or many port
	

	# download unfully-config-redirect
	[[ ! -f redirect.sh ]] && wget https://github.com/yompc/Student_Management_System_2018/raw/master/redirect.sh

	# config: haproxy && redirect
	if [[ "1" == "1" ]]; then
		 
		 [[ -z "30080" ]] && port1=443
		 config-haproxy-1
		 config-redirect-1
	else
		 echo -e "${Info} 输入端口段的第一个端口号"
		 read -p "(例如端口段为 8080-9090，则此处输入 8080，默认使用 8080):" port1
		 [[ -z "${port1}" ]] && port1=8080
		 echo -e "${Info} 输入端口段的第二个端口号"
		 read -p "(例如端口段为 8080-9090，则此处输入 9090，默认使用 9090):" port2
		 [[ -z "${port2}" ]] && port2=9090
		 config-haproxy-2
		 config-redirect-2
	fi
}

config-haproxy-1(){
echo -e "global

defaults
log global
mode tcp
option dontlognull
timeout connect 5000
timeout client 10000
timeout server 10000

frontend proxy-in
bind *:30080
default_backend proxy-out

backend proxy-out
server server1 10.0.0.1 maxconn 20480\c" > haproxy.cfg
}

config-haproxy-2(){
echo -e "global

defaults
log global
mode tcp
option dontlognull
timeout connect 5000
timeout client 10000
timeout server 10000

frontend proxy-in
bind *:${port1}-${port2}
default_backend proxy-out

backend proxy-out
server server1 10.0.0.1 maxconn 20480\c" > haproxy.cfg
}

config-redirect-1(){
echo "iptables -t nat -A PREROUTING -i eth0 -p tcp --dport ${port1} -j DNAT --to-destination 10.0.0.2" >> redirect.sh
}

config-redirect-2(){
echo "iptables -t nat -A PREROUTING -i eth0 -p tcp --dport ${port1}:${port2} -j DNAT --to-destination 10.0.0.2" >> redirect.sh
}

check-all(){
	# check config
	[[ ! -f haproxy.cfg ]] && echo -e "${Error} not found haproxy config, please check !" && exit 1
	[[ ! -f redirect.sh ]] && echo -e "${Error} not found redirect config, please check !" && exit 1

	# check lkl-mod
	[[ ! -f tcp_nanqinlang.so ]] && wget https://raw.githubusercontent.com/tcp-nanqinlang/lkl-haproxy/master/mod/tcp_nanqinlang.so
	[[ ! -f tcp_nanqinlang.so ]] && echo -e "${Error} download lkl.mod failed, please check !" && exit 1

	# check lkl-load
	[[ ! -f load.sh ]] && wget https://raw.githubusercontent.com/tcp-nanqinlang/lkl-haproxy/master/requirement/load.sh
	[[ ! -f load.sh ]] && echo -e "${Error} download load.sh failed, please check !" && exit 1

	# check haproxy
	apt-get install -y iptables bc haproxy

	# check selfstart
	[[ ! -f start.sh ]] && wget https://raw.githubusercontent.com/tcp-nanqinlang/lkl-haproxy/master/requirement/start.sh
	[[ ! -f start.sh ]] && echo -e "${Error} download start config failed, please check !" && exit 1

	# give privilege
	chmod -R +x /home/tcp_nanqinlang
}

# start immediately
run-it-now(){
	./start.sh
}

# start with reboot
self-start(){
	sed -i "s/exit 0/ /ig" /etc/rc.local
	echo -e "\nbash /home/tcp_nanqinlang/start.sh" >> /etc/rc.local
	chmod +x /etc/rc.local
}


install(){
	
	directory
	config
	check-all
	run-it-now
	self-start
	#status
	echo -e "${Info} 已完成，请稍后使用此脚本第二项判断 lkl 是否成功。"
}





if [[ "1" == "1" ]]; then
	install
