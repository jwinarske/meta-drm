#
# Copyright (c) 2024 Joel Winarske. All rights reserved.
#

SUMMARY = "Small utility to dump info about DRM devices"
AUTHOR = "Simon Ser"
HOMEPAGE = "https://gitlab.freedesktop.org/emersion/drm_info"
BUGTRACKER = "https://gitlab.freedesktop.org/emersion/drm_info/-/issues"
SECTION = "graphics"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=32fd56d355bd6a61017655d8da26b67c"

DEPENDS += "\
    json-c \
    libdrm \
    pciutils \
   "

SRCREV = "210f7c8c22979063f4180cef6587273091842712"
SRC_URI = "git://gitlab.freedesktop.org/emersion/drm_info.git;protocol=https;branch=master"

inherit pkgconfig meson
