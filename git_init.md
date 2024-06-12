1、在本地项目目录中初始化Git仓库：


```bash
git init
```

2、将项目文件添加到Git的缓存区（暂存区）：

```bash
git add .
```


3、提交更改到本地Git仓库：

```bash
git commit -m "Initial commit"
```

4、将本地的Git仓库推送到远程Git仓库：

```bash
git remote add origin <remote_repository_URL>
```

```bash
git remote add origin git@github.com:fdxzhen/InitialDemo.git
```

5、推送本地仓库到远程仓库：
```bash
git push -u origin master
```