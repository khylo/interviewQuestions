let moveHistory = new Map()
var Blank = "Blank", Full="Full", Knight="Knight"
function onDropBlank(source, target, piece, newPos, oldPos, orientation){
    addHistory(Blank, source, target, piece, newPos, oldPos, orientation)
}
function onDropFull(source, target, piece, newPos, oldPos, orientation){
    addHistory(Full, source, target, piece, newPos, oldPos, orientation)

}
function onDropKnight(source, target, piece, newPos, oldPos, orientation){
    addHistory(Knight, source, target, piece, newPos, oldPos, orientation)
}


function addHistory(board, source, target, piece, newPos, oldPos, orientation){
    let bh = moveHistory.get(board)
    if(bh===undefined)
        bh = []
    bh.push({source, target, piece, newPos, oldPos, orientation})
    moveHistory.set(board,bh)
    console.log("Adding move "+bh.length+" to "+board)
    console.log('Source: ' + source)
    console.log('Target: ' + target)
    console.log('Piece: ' + piece)
    console.log('New position: ' + Chessboard.objToFen(newPos))
    console.log('Old position: ' + Chessboard.objToFen(oldPos))
    console.log('Orientation: ' + orientation)
    console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')
}

function undoMove(){

}
moveHistory.blanklBoard = {}
let configBlank = {
    draggable: true,
    onDrop : onDropBlank,
    sparePieces: true
  }
// Blank Board
let name = 'blankBoard'
var blanklBoard = Chessboard(name, configBlank)
// Full  Board
let configFull = {
    draggable: true,
    onDrop : onDropFull,
    position : 'start',
    sparePieces: true
  }
name = 'fullBoard'
var fullBoard = Chessboard(name, configFull)
// WhiteKnightBoard
let configKnight = {
    draggable: true,
    onDrop : onDropKnight,
    position : { a1:'wN'}
  }
name = 'knightBoard'
var knightBoard = Chessboard(name, configKnight)