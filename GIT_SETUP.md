# Git 仓库设置指南

## 将项目提交到 GitHub

按照以下步骤将项目提交到 GitHub 仓库：https://github.com/lovefunCode/AndroidApp.git

### 步骤 1: 初始化 Git 仓库

```bash
cd /Users/4paradigm/Documents/AndroidApp
git init
```

### 步骤 2: 添加远程仓库

```bash
git remote add origin https://github.com/lovefunCode/AndroidApp.git
```

### 步骤 3: 检查远程仓库

```bash
git remote -v
```

应该显示：
```
origin  https://github.com/lovefunCode/AndroidApp.git (fetch)
origin  https://github.com/lovefunCode/AndroidApp.git (push)
```

### 步骤 4: 添加所有文件

```bash
git add .
```

### 步骤 5: 提交更改

```bash
git commit -m "Initial commit: Android App with React Native 0.80.2 integration"
```

或者使用更详细的提交信息：

```bash
git commit -m "Initial commit: Android App with React Native 0.80.2 integration

- Integrated React Native 0.80.2 into Android project
- Implemented App Shell architecture
- Separated React Native code into react-native/ folder
- Updated Android dependencies and configurations
- Added comprehensive documentation"
```

### 步骤 6: 设置默认分支（如果需要）

```bash
git branch -M main
```

### 步骤 7: 推送到 GitHub

```bash
git push -u origin main
```

如果远程仓库已经有内容，可能需要先拉取：

```bash
git pull origin main --allow-unrelated-histories
git push -u origin main
```

## 完整的命令序列

```bash
# 1. 初始化仓库
git init

# 2. 添加远程仓库
git remote add origin https://github.com/lovefunCode/AndroidApp.git

# 3. 添加所有文件
git add .

# 4. 提交
git commit -m "Initial commit: Android App with React Native 0.80.2 integration"

# 5. 设置分支名称
git branch -M main

# 6. 推送到 GitHub
git push -u origin main
```

## 注意事项

1. **确保已登录 GitHub**：如果使用 HTTPS，可能需要输入 GitHub 用户名和密码（或 Personal Access Token）

2. **如果远程仓库已有内容**：
   - 如果远程仓库是空的，直接推送即可
   - 如果远程仓库已有 README.md 等文件，需要先拉取：
     ```bash
     git pull origin main --allow-unrelated-histories
     git push -u origin main
     ```

3. **使用 Personal Access Token**：
   - 如果 GitHub 要求身份验证，可以使用 Personal Access Token 代替密码
   - 创建 Token：GitHub Settings → Developer settings → Personal access tokens → Tokens (classic)

4. **检查 .gitignore**：
   - 确保 `node_modules/`、`build/` 等文件不会被提交
   - 已更新 `.gitignore` 包含 `react-native/node_modules/`

## 验证

推送成功后，访问 https://github.com/lovefunCode/AndroidApp 查看你的代码。

## 后续提交

以后每次修改后，使用以下命令提交：

```bash
git add .
git commit -m "描述你的更改"
git push
```

