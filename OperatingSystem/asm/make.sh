nasm -f elf string_length.asm 
ld -m elf_i386 string_length.o -o main
./main