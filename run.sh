#!/usr/bin/env bash
# 定义应用组名
group_name='miaosha'
# 定义应用名称
app_name='miaosha-drone'
# 定义应用版本
app_version='0.0.1-SNAPSHOT'
# 定义应用环境
#profile_active='prod'
echo '----copy jar----'
docker stop ${app_name}
echo '----stop container----'
docker rm ${app_name}
echo '----rm container----'
docker rmi ${group_name}/${app_name}:${app_version}
echo '----rm image----'
# 打包编译docker镜像
docker build -t ${group_name}/${app_name}:${app_version} .
echo '----build image----'
docker run -p 8080:8080 --name ${app_name}  --net docker-mynet --ip 172.172.0.88 \
-e TZ="Asia/Shanghai" \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/${app_name}/logs:/var/logs \
-d ${group_name}/${app_name}:${app_version} \

echo '----start container----'