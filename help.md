镜像名：rastasheep/ubuntu-sshd:18.04

账号: root

密码: root

改密码：passwd root



安装SS

```shell
apt-get update -y &&
apt-get install shadowsocks-libev -y &&
apt-get install nload &&
apt-get install vim -y &&
wget https://github.com/yompc/Student_Management_System_2018/raw/master/config.json -O /etc/shadowsocks-libev/config.json && 
apt-get install net-tools -y &&
echo "nameserver 1.1.1.1" >/etc/resolv.conf &&
apt-get install iproute2  -y &&
apt-get install iputils-ping -y &&
apt-get install iptables -y ;
```

配置SS

```shell
vi /etc/shadowsocks-libev/config.json
```

配置信息

|                                   |                                             |
| --------------------------------- | ------------------------------------------- |
| "server":"0.0.0.0",               | 不用改，就是0.0.0.0                         |
| "server_port":9090,               | 监听端口，就是你BBR加速的那个端口           |
| "local_port":1080,                | 不用改                                      |
| "password":"yompc535",            | 这个是密码自己改掉                          |
| "timeout":600,                    | 不用管                                      |
| "method":"chacha20-ietf-poly1305" | 加密方式，如果你是用SSR的可以改成chacha20等 |
|                                   |                                             |

安装nanqinglang 魔改BBR 并启用

```shell
apt-get install wget &&
wget https://github.com/yompc/Student_Management_System_2018/raw/master/tcp_nanqinlang-haproxy-debian-nocheckvirt.sh && bash tcp_nanqinlang-haproxy-debian-nocheckvirt.sh ;
```

不知为何启动完BBR之后还要添加这一条Iptables规则才稳定，不然twitch和gmail打不开，遇到打不开在服务器端运行这段配置后重启你的电脑，即可

```shell
iptables -P FORWARD ACCEPT
```

启动SS 

```shell
/etc/init.d/shadowsocks-libev stop &&
echo 1 > /proc/sys/vm/drop_caches &&
/etc/init.d/shadowsocks-libev start ;
```



