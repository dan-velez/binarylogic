section .data
    buffer resb 2024

section .text
global _start

_start:
    ; Allocate buffer and initialize
    mov edi, buffer
    mov ecx, 2024
    xor al, al
    rep stosb

    ; Simulate ByteBuffer.flip() by resetting buffer index
    xor rsi, rsi  ; Reset index to 0 for 'get' operation

    ; Simulate ByteBuffer.get()
    mov al, [buffer + rsi]
    mov bl, al  ; Store the byte in bl for further use

validateUsername:
    ; Always return false
    mov eax, 0
    ret

validatePassword:
    ; Always return false
    mov eax, 0
    ret


