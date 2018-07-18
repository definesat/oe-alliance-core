require recipes-mediacenter/kodi/stb-kodi_${PV}.bb

SRCDATE = "20180718"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_remove = "file://e2player.patch \
           file://add-gstplayer-support.patch \
"

SRC_URI_append = "http://define-sw.dyndns.tv:8082/clap/hiplayer_${SRCDATE}.tar.gz \
                  file://hiplayer.patch \
"

SRC_URI[md5sum] = "75afa2025026218fb173f74637ba5d7f"
SRC_URI[sha256sum] = "c1a8273aeb330e27ce353aac4c6f35b95177fa41e9810d9b1a496b6b916f8ec7"

DEPENDS += "clap-libs-${MACHINE}"
PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES_${PN} += "kodi"

RDEPENDS_${PN} += "clap-libs-${MACHINE}"
RDEPENDS_${PN} += "clap-opengl-${MACHINE}"

do_configure_append() {
        install -d ${D}${libdir}
        install -m 0755 ${WORKDIR}/hiadp.a      ${WORKDIR}/git/xbmc/linux/hisi/
        install -m 0755 ${WORKDIR}/hiplayer.a   ${WORKDIR}/git/xbmc/cores/hiplayer/
}

EXTRA_OECONF += " \
    --with-platform=clap-cortexa15 \
    --with-ffmpeg=stb \
"