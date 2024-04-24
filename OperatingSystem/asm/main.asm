; Using system calls to access the kernel libraries. System calls suspend the
; program, contact drivers, then return control to program.
; Load EAX with the sys call number. Fill in the remaining registers with
; arguments. Use INT to call the interupt.

SECTION .data
msg db  'Hello, World!', 0AH

SECTION .text
global _start

_start:
    mov edx, 13     ; Number of bytes to write
    mov ecx, msg    ; Memory address of message.
    mov ebx, 1      ; Write to STDOUT
    mov eax, 4      ; Sys call number
    int 80h         ; Call sys call.

    mov ebx, 0      ; Return status
    mov eax, 1      ; SYS_EXIT
    int 80h