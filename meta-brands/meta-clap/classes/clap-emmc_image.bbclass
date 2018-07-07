inherit image_types

IMAGE_TYPEDEP_clapemmc = "ext4"

IMAGE_DEPENDS_clapemmc = " \
    parted-native \
    dosfstools-native \
    mtools-native \
    virtual/kernel \
    clap-buildimage-native \
    "

IMAGE_CMD_clapemmc () {

}
