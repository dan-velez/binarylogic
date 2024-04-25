section .data
    helloMessage db "Hello, world!", 0

section .text
    global _start

_start:
    ; Print "Hello, world!"
    mov eax, 4          ; syscall number for sys_write
    mov ebx, 1          ; file descriptor 1 is stdout
    mov ecx, helloMessage ; message to write
    mov edx, 13         ; message length
    int 0x80            ; call kernel

    ; Exit the program
    mov eax, 1          ; syscall number for sys_exit
    xor ebx, ebx        ; return 0 status
    int 0x80            ; call kernel

validateUsername:
    ; Stub function for username validation
    mov eax, 0          ; return false
    ret

validatePassword:
    ; Stub function for password validation
    mov eax, 0          ; return false
    ret