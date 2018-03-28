#
# linux-rushup-710 - branch 4.4.71
# (C)2018 - Matteo Fumagalli - <matteofumagalli1275@gmail.com>
#

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "4.4.71"


SRC_URI = " git://github.com/rushup/rushup-linux-artik.git;protocol=https;branch=A710/v4.4"

SRCREV = "013f0a592a45647932eccb96d4fdfece0da23712"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

do_compile_append_kitra710C() {
	#Uboot laways loads rev03
	cp ${B}/arch/${ARCH}/boot/dts/nexell/s5p6818-kitra710C.dtb ${B}/arch/${ARCH}/boot/dts/nexell/s5p6818-artik710-raptor-rev03.dtb

}

do_compile_append_kitragti() {
	#Uboot laways loads rev03
	cp ${B}/arch/${ARCH}/boot/dts/nexell/s5p6818-kitragti.dtb ${B}/arch/${ARCH}/boot/dts/nexell/s5p6818-artik710-raptor-rev03.dtb

}

PV = "${LINUX_VERSION}+git${SRCPV}"

S = "${WORKDIR}/git"

# The defconfig was created with make_savedefconfig so not all the configs are in place
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "(kitra710C|kitragti)"
