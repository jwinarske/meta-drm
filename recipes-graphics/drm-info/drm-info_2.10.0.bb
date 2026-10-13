#
# Copyright (c) 2024 Joel Winarske. All rights reserved.
#

SUMMARY = "Small utility to dump info about DRM devices"
AUTHOR = "Simon Ser"
HOMEPAGE = "https://gitlab.freedesktop.org/emersion/drm_info"
BUGTRACKER = "https://gitlab.freedesktop.org/emersion/drm_info/-/issues"
SECTION = "graphics"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=32fd56d355bd6a61017655d8da26b67c"

DEPENDS += "\
    json-c \
    libdrm \
    pciutils \
   "

SRCREV = "462458e0f292145b2a9d5a8b65c392eaeef7362d"
SRC_URI = "git://gitlab.freedesktop.org/emersion/drm_info.git;protocol=https;branch=master"

inherit pkgconfig meson

EXTRA_OEMESON += "-Dlibpci=enabled -Dman-pages=disabled"

PACKAGECONFIG ??= "libdisplay-info"
PACKAGECONFIG[libdisplay-info] = "-Dlibdisplay-info=enabled,-Dlibdisplay-info=disabled,libdisplay-info"
