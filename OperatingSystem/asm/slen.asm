; Simpler environment.
; Bare bones.
; SYSCALLS and hardware interrupts.

; Pointer arithmetic. 2 pointers start at beginning. Increment one for each 
; byte. Subtract to get length.
; CMP compares left hand side against right hand side. 

SECTION .data
msg     db      'Hello, brave new world!', 0Ah

SECTION .text
global _start

_start:
    mov     ebx, msg        ; Move address of message.
    mov     eax, ebx        ; Move address in EBX to EAX. Both point to same.

nextchar:
    cmp     byte [eax], 0   ; Compare eax against 0
    jz      finished
    inc     eax
    jmp     nextchar

finished:
    sub     eax, ebx        ; Number of segments between 2 addresses. In bytes.
    
    mov     edx, eax        ; Length of string
    mov     ecx, msg        ; Memory address of message.
    mov     ebx, 1          ; STDOUT
    mov     eax, 4          ; SYS_WRITE (opcode 4)
    int     80h

    mov     ebx, 0
    mov     eax, 1
    int     80h