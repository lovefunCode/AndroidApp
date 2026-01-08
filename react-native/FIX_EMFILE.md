# Fix EMFILE: too many open files Error

This error occurs because macOS has a low file descriptor limit, and Metro needs to monitor a large number of files.

## Solutions (by priority)

### Solution 1: Install Watchman (Highly Recommended)

Watchman is a file watching service developed by Facebook that can significantly reduce file descriptor usage.

```bash
# Install Watchman
brew install watchman

# Reset Watchman
watchman watch-del-all
watchman shutdown-server

# Increase file descriptor limit
ulimit -n 4096

# Restart Metro
cd react-native
npm start
```

### Solution 2: Increase File Descriptor Limit (Temporary)

Before starting Metro, run in the terminal:

```bash
# Increase file descriptor limit for current terminal
ulimit -n 4096

# Or a larger value
ulimit -n 8192

# Then start Metro
cd react-native
npm start
```

**Note**: This setting only applies to the current terminal session. You'll need to set it again after closing the terminal.

### Solution 3: Permanently Increase System Limit (Requires Admin Privileges)

Edit `/etc/launchd.conf` (create if it doesn't exist):

```bash
sudo nano /etc/launchd.conf
```

Add the following content:

```
limit maxfiles 65536 200000
```

Then restart the system, or run:

```bash
sudo launchctl limit maxfiles 65536 200000
```

### Solution 4: Use Polling Mode (Alternative)

If the above solutions don't work, you can configure Metro to use polling mode (consumes more CPU but doesn't require as many file descriptors):

When starting in the `react-native/` directory:

```bash
cd react-native
METRO_USE_POLLING=1 npm start
```

Or modify the start script in `package.json`:

```json
"start": "METRO_USE_POLLING=1 react-native start --port 9000"
```

## Recommended Steps

1. **First try installing Watchman** (Solution 1) - This is the most recommended solution
2. If Watchman installation fails, use Solution 2 to temporarily increase the limit
3. If you frequently encounter this issue, consider Solution 3 to permanently increase the system limit

## Verification

After starting Metro, if the `EMFILE` error no longer appears, the issue is resolved.
