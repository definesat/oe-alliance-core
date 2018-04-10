inherit image_types

IMAGE_TYPEDEP_clapemmc = "ext4"

IMAGE_DEPENDS_clapemmc = " \
    parted-native \
    dosfstools-native \
    mtools-native \
    virtual/kernel \
    "

GPT_OFFSET = "0"
GPT_SIZE = "1024"

ROOTFS_PARTITION_OFFSET = "$(expr ${GPT_OFFSET} \+ ${GPT_SIZE})"
ROOTFS_PARTITION_SIZE = "1048576"

STORAGE_PARTITION_OFFSET = "$(expr ${ROOTFS_PARTITION_OFFSET} \+ ${ROOTFS_PARTITION_SIZE})"

EMMC_IMAGE = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.emmc.img"
EMMC_IMAGE_SIZE = "3817472"

IMAGE_CMD_clapemmc () {
    dd if=/dev/zero of=${EMMC_IMAGE} bs=1024 count=0 seek=${EMMC_IMAGE_SIZE}
    parted -s ${EMMC_IMAGE} mklabel gpt
    parted -s ${EMMC_IMAGE} unit KiB mkpart rootfs1 ext2 ${ROOTFS_PARTITION_OFFSET} $(expr ${ROOTFS_PARTITION_OFFSET} \+ ${ROOTFS_PARTITION_SIZE})
    parted -s ${EMMC_IMAGE} unit KiB mkpart storage ext2 ${STORAGE_PARTITION_OFFSET} $(expr ${EMMC_IMAGE_SIZE} \- 1024)
    resize2fs ${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.ext4 ${ROOTFS_PARTITION_SIZE}k
    # Truncate on purpose
    dd if=${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.ext4 of=${EMMC_IMAGE} bs=1024 seek=${ROOTFS_PARTITION_OFFSET} count=${IMAGE_ROOTFS_SIZE}
}
