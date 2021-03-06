# We know about rtc
include conf/machine/include/build-extras.inc

DISTRO_FEATURES_remove = "x11 wayland"

BRAND_OEM = "clap"

IMAGEDIR = "clap/${MACHINE}"

MACHINE_NAME = "\
${@bb.utils.contains('MACHINEBUILD', 'clap4k', 'CLAP 4K' , '', d)}\
"

MACHINE_BRAND = "\
${@bb.utils.contains('MACHINEBUILD', 'clap4k', 'CLAP' , '', d)}\
"

MTD_KERNEL = "\
${@bb.utils.contains('MACHINEBUILD', 'clap4k', 'mmcblk0p12' , '', d)}\
"

MTD_ROOTFS = "\
${@bb.utils.contains('MACHINEBUILD', 'clap4k', 'mmcblk0p13' , '', d)}\
"

KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.tar.bz2"
MTD_BLACK  = "mmcblk0"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS = "\
    clap-dvb-modules-${MACHINE} \
    clap-loadmodules-${MACHINE} \ 
    clap-opengl-${MACHINE} \
    clap-libs-${MACHINE} \
    clap-hihalt-${MACHINE} \
    clap-reader-${MACHINE} \
    clap-libreader-${MACHINE} \
    clap-blindscan-${MACHINE} \
    clap-partitions-${MACHINE} \
"

MACHINE_FEATURES += "nowifi videoenhancement switchoff  hdmicec 7segment textlcd skins1080 blindscan-tbs emmc mmc"

IMAGE_CLASSES  += "clap-emmc_image"
IMAGE_FSTYPES += "clapemmc"
IMAGE_ROOTFS_SIZE ?= "294912"

TARGET_ARCH = "arm"
DEFAULTTUNE = "cortexa15hf-neon-vfpv4"

PREFERRED_VERSION_linux-clap = "4.4.35"
PREFERRED_VERSION_linux-libc-headers = "4.4"
PREFERRED_PROVIDER_virtual/egl = "clap-opengl-${MACHINE}" 
PREFERRED_PROVIDER_virtual/libgles2 = "clap-opengl-${MACHINE}"
PREFERRED_PROVIDER_virtual/kodi = "stb-kodi-${MACHINE}"

require conf/machine/include/tune-cortexa15.inc

MACHINE_EXTRA_RRECOMMENDS = " \
    gstreamer1.0-plugin-dvbmediasink \
    gstreamer1.0-libav \
    "

DVBPROVIDER = "kernel"
DVBSKYPROVIDER = "kernel"

include conf/machine/include/autoload-filesystems.inc
require conf/machine/include/soc-family.inc

DVBMEDIASINK_CONFIG = "--with-h265 --with-vb8 --with-vb9 --with-spark --with-opus --with-wma --with-wmv --with-pcm --with-dts --with-eac3"

PREFERRED_PROVIDER_virtual/libgles1 = "clap-opengl-${MACHINE}"
PREFERRED_PROVIDER_virtual/libgles2 = "clap-opengl-${MACHINE}"
PREFERRED_PROVIDER_virtual/egl = "clap-opengl-${MACHINE}"

PREFERRED_PROVIDER_virtual/kernel = "linux-clap"
PREFERRED_RPROVIDER_showiframe = "clap-showiframe-${MACHINE}"
PREFERRED_RPROVIDER_aio-grab = "clap-grab-${MACHINE}"
PREFERRED_VERSION_directfb = "1.7.7"

IMAGE_CMD_clapemmc_append = "\
    mkdir -p ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}; \
    cp ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.ext4 ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions/rootfs.ext4; \
    cd ${IMAGE_ROOTFS}; \
    tar -cvf ${DEPLOY_DIR_IMAGE}/rootfs.tar -C ${IMAGE_ROOTFS} .; \
    mv ${DEPLOY_DIR_IMAGE}/rootfs.tar ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.tar; \
    bzip2 ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.tar; \
    cp ${DEPLOY_DIR_IMAGE}/uImage ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE}; \
    cp ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE} ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions/${KERNEL_FILE}; \
    echo ${IMAGE_VER_STRING} > ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/imageversion; \
    cd ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions; \
    mkupdate -s 00000003-00000001-01010101 -f ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions/emmc_partitions.xml -d ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/usb_update.bin; \    
    cd ${DEPLOY_DIR_IMAGE}; \
    zip ${IMAGE_NAME}_mmc.zip ${IMAGEDIR}/*; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.ext4; \
    rm -f ${DEPLOY_DIR_IMAGE}/*.manifest; \
    rm -f ${DEPLOY_DIR_IMAGE}/.ext4; \
    rm -f ${DEPLOY_DIR_IMAGE}/.manifest; \
    rm -f -f ${DEPLOY_DIR_IMAGE}/*.json; \
    rm -Rf ${IMAGEDIR}; \
    "


OEM_ARCH = "${MACHINEBUILD}"

# Add "MACHINEBUILD" override for recipes
MACHINEOVERRIDES =. "${@['', '${MACHINEBUILD}:']['${MACHINEBUILD}' != '']}"

BBMASK = "meta-vuplus/recipes-graphics/"
BBMASK += "meta-vuplus/recipes-webkit/"
