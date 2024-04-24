od -t x1 -A n bin/bootloader.bin
nasm -f bin bootloader.asm -o bin/bootloader.bin
qemu-system-x86_64 bin/bootloader.bin