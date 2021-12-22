# myci-builder
Build jobs to create tools and compile kernels, AOSP, etc for various targets

# Pre-requisites

```
sudo apt install libncurses5
sudo apt install repo
```

## repo

If the version is too old or unavailable check instructions for getting latest
version

[https://source.android.com/setup/develop#installing-repo](https://source.android.com/setup/develop#installing-repo)

## uclampset

We need uclampset which is part of util-linux 2.37.2

`sudo apt install util-linux`

If your distro's version is old you can build it from source:

[https://github.com/util-linux/util-linux](https://github.com/util-linux/util-linux)
