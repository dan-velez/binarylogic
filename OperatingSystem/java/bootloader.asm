; x64 Bootloader

[ORG 0x7C00]   ; Set origin to 0x7C00 (standard address where bootloaders
               ; are loaded)

section .text   ; Text section

; Entry point
start:
    ; Set up stack pointer
    mov rsp, 0x7C00

    ; Clear screen
    mov ah, 0x06    ; BIOS function for scroll screen up
    xor al, al      ; Clear entire screen
    mov cx, 0       ; Upper left corner (row 0, column 0)
    mov dh, 24      ; Lower right corner (row 24, column 80)
    mov bh, 0x0F    ; White on black
    int 0x10        ; Call BIOS interrupt for video services

    ; Print message
    mov si, message ; Pointer to message string
    call print_string   ; Call print_string subroutine

    ; Infinite loop
    cli         ; Clear interrupts
    hlt         ; Halt processor

print_string:
    ; Loop through string until null-terminator is found
    .next_char:
        lodsb   ; Load byte at address DS:SI into AL, increment SI
        test al, al    ; Check if byte is null-terminator
        jz .done       ; If null-terminator, jump to done
        mov ah, 0x0E   ; BIOS function for teletype output
        mov bh, 0x00   ; Page number
        mov bl, 0x0F   ; Text attribute (white on black)
        int 0x10       ; Call BIOS interrupt for video services
        jmp .next_char ; Continue loop

    .done:
        ret           ; Return from subroutine

message db 'Hello, x64 World!', 0  ; Message string

times 510 - ($ - $$) db 0   ; Fill the rest of the boot sector with zeros
dw 0xAA55   ; Boot signature (0xAA55)