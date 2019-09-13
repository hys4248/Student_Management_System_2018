#!/bin/bash

#author     xiaobao 

#date       2016-12-22 21:12:25

#delete

Date=$(date +%Y%m%d%H%M%S)

cp  /etc/sysctl.conf  /etc/sysctl.conf_${Date}

sed -i "/^fs.file-max/d" /etc/sysctl.conf

sed -i "/^net.nf_conntrack_max/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_max_tw_buckets/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_sack/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_window_scaling/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_rmem/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_wmem/d" /etc/sysctl.conf

sed -i "/^net.core.wmem_default/d" /etc/sysctl.conf

sed -i "/^net.core.rmem_default/d" /etc/sysctl.conf

sed -i "/^net.core.rmem_max/d" /etc/sysctl.conf

sed -i "/^net.core.wmem_max/d" /etc/sysctl.conf

sed -i "/^net.core.netdev_max_backlog/d" /etc/sysctl.conf

sed -i "/^net.core.somaxconn/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_max_orphans/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_max_syn_backlog/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_timestamps/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_synack_retries/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_syn_retries/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_syncookies/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_tw_recycle/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_tw_reuse/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_mem/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_fin_timeout/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_keepalive_time/d" /etc/sysctl.conf

sed -i "/^net.ipv4.tcp_abort_on_overflow/d" /etc/sysctl.conf

sed -i "/^net.ipv4.ip_local_port_range/d" /etc/sysctl.conf

sed -i "/^fs.file-max/d" /etc/sysctl.conf

#add

cat >> /etc/sysctl.conf << EOF

fs.file-max=65535

net.nf_conntrack_max=200000

net.ipv4.tcp_max_tw_buckets = 6000

net.ipv4.tcp_sack = 1

net.ipv4.tcp_window_scaling = 1

net.ipv4.tcp_rmem = 8760  256960  4088000

net.ipv4.tcp_wmem = 8760  256960  4088000

net.core.wmem_default = 8388608

net.core.rmem_default = 8388608

net.core.rmem_max = 16777216

net.core.wmem_max = 16777216

net.core.netdev_max_backlog = 262144

net.core.somaxconn = 262144

net.ipv4.tcp_max_orphans = 3276800

net.ipv4.tcp_max_syn_backlog = 262144

net.ipv4.tcp_timestamps = 0

net.ipv4.tcp_synack_retries = 1

net.ipv4.tcp_syn_retries = 1

net.ipv4.tcp_syncookies = 1

net.ipv4.tcp_tw_recycle = 1

net.ipv4.tcp_tw_reuse = 1

net.ipv4.tcp_mem = 6291456 7864320 12582912

net.ipv4.tcp_fin_timeout = 1

net.ipv4.tcp_keepalive_time = 30

net.ipv4.tcp_abort_on_overflow = 1

net.ipv4.ip_local_port_range = 1024    65000

fs.file-max = 1020000

EOF

/sbin/sysctl -p
